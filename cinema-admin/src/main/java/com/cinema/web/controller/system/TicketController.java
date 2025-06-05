package com.cinema.web.controller.system;

import com.cinema.common.response.ResponseResult;
import com.cinema.system.domin.Ticket;
import com.cinema.system.domin.vo.TicketVo;
import com.cinema.system.service.TicketService;
import com.cinema.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController {

    @Autowired
    private TicketService ticketService;

    /**
     * 查询电影票列表
     */
    @GetMapping
    public ResponseResult findAll(Ticket ticket) {
        startPage();
        List<TicketVo> data = ticketService.findTicketVos(ticket);
        return getResult(data);
    }

    /**
     * 根据ID查询电影票
     */
    @GetMapping("/{id}")
    public ResponseResult findById(@PathVariable Long id) {
        return getResult(ticketService.getTicketVoById(id));
    }

    /**
     * 添加电影票
     */
    @PostMapping
    public ResponseResult add(@Validated @RequestBody Ticket ticket) {
        Object obj = ticketService.add(ticket);
        if (obj instanceof TicketVo) {
            return ResponseResult.success("操作成功", obj);
        }
        return ResponseResult.error("添加失败");
    }

    /**
     * 更新电影票信息
     */
    @PutMapping
    public ResponseResult update(@RequestBody Ticket ticket) {
        return getResult(ticketService.update(ticket));
    }

    /**
     * 删除电影票
     */
    @DeleteMapping("/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids) {
        return getResult(ticketService.delete(ids));
    }

    /**
     * 更新电影票状态
     */
    @PutMapping("/state/{ticketId}/{newState}")
    public ResponseResult updateTicketState(@PathVariable Long ticketId, @PathVariable Integer newState) {
        return getResult(ticketService.updateTicketState(ticketId, newState));
    }

    /**
     * 根据订单ID查询电影票列表
     */
    @GetMapping("/bill/{billId}")
    public ResponseResult findByBillId(@PathVariable Long billId) {
        return getResult(ticketService.findByBillId(billId));
    }

    /**
     * 根据用户ID查询电影票列表
     */
    @GetMapping("/user/{userId}")
    public ResponseResult findByUserId(@PathVariable Long userId) {
        return getResult(ticketService.findByUserId(userId));
    }

    /**
     * 根据订单ID生成电影票
     */
    @PostMapping("/generate/{billId}")
    public ResponseResult generateTicketsByBillId(@PathVariable Long billId) {
        List<TicketVo> tickets = ticketService.generateTicketsByBillId(billId);
        return ResponseResult.success("生成成功", tickets);
    }

    /**
     * 根据用户手机号查询电影票列表
     */
    @GetMapping("/ticket/phone/{phoneNumber}")
    public ResponseResult findByPhoneNumber(@PathVariable String phoneNumber) {
        List<TicketVo> ticketVos = ticketService.findByPhoneNumber(phoneNumber);
        return ResponseResult.success(ticketVos);
    }
}