package com.example.servicethanhtoan.controler;

import com.example.servicethanhtoan.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/thanhtoan")
public class VNPayController {

    private final VNPayService vnPayService;


    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") int orderTotal,
                              @RequestParam("orderInfo") String orderInfo,
                              HttpServletRequest request){
        String portReact = "3000";
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" +  portReact;
//        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
    }

    @GetMapping("/vnpay-payment")
    public ResponseEntity<String> getPaymentStatus(HttpServletRequest request){
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        return ResponseEntity.ok(paymentTime) ;
    }
}
