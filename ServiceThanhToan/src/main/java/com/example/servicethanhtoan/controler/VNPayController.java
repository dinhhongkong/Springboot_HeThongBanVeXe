package com.example.servicethanhtoan.controler;

import com.example.servicethanhtoan.dto.response.PaymentResponse;
import com.example.servicethanhtoan.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VNPayController {

    private final VNPayService vnPayService;


    @GetMapping("")
    public String home(){
        return "hello world";
    }

    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") int orderTotal,
                              @RequestParam("orderInfo") String orderInfo,
                              HttpServletRequest request){
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
    }

    @GetMapping("/vnpay-payment")
    public ResponseEntity<PaymentResponse> GetMapping(HttpServletRequest request){
        int paymentStatus =vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentStatus(paymentStatus);
        paymentResponse.setOrderInfo(orderInfo);
        paymentResponse.setTotalPrice(totalPrice);
        paymentResponse.setPaymentTime(paymentTime);
        paymentResponse.setTransactionId(transactionId);
        return ResponseEntity.ok(paymentResponse) ;
    }
}
