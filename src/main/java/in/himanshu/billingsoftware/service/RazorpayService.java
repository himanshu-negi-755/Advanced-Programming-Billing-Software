package in.himanshu.billingsoftware.service;

import com.razorpay.RazorpayException;
import in.himanshu.billingsoftware.io.RazorpayOrderResponse;

public interface RazorpayService {

    RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;
}
