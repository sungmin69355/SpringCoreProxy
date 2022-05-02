package hello.proxy.app.v2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @RequestMapping : 스프링MVC는 타입에 @Controller 또는 @RequestMapping 애노테이션이 있어야 스프링 컨트롤러로 인식한다.
 * 그리고 스프링 컨트롤러로 인식해야, HTTP URL이 매핑되고 동작한다. 그런데 여기서는 @Controller 를 사용하지 않고, @RequestMapping 애노테이션을 사용했다.
 * 그 이유는 @Controller 를 사용하면 자동 컴포넌트 스캔의 대상이 되기 때문이다. 여기서는 컴포넌트 스캔을 통한 자동 빈 등록이 아니라 수동 빈 등록을 하는 것이 목표다.
 * 따라서 컴포넌트 스캔과 관계 없는 @RequestMapping 를 타입에 사용했다.
 */
@Slf4j
@RequestMapping
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }

}
