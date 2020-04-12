package test.vo;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyOrderListVO {
    List<OrderVO> unConfirmedList = new ArrayList<>();
    List<OrderVO> unTestList = new ArrayList<>();
    List<OrderVO> unAccomplishList = new ArrayList<>();
}
