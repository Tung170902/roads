package com.example.roads.road;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = {"api/v1/orders"}
)
public class OrderApi {
    @Autowired
    RoadService roadService;

    public OrderApi() {
    }

    @RequestMapping(
            method = {RequestMethod.POST}
    )
    public Road save(@RequestBody Road road) {
        return this.roadServiceService.save(road);
    }

    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Road> findAll() {
        return this.roadService.findAll();
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"/{id}"}
    )
    public Road getDetail(@PathVariable int id) {
        return (Road)this.roadServiceService.findById(id).get();
    }

    @RequestMapping(
            method = {RequestMethod.DELETE},
            path = {"/{id}"}
    )
    public boolean delete(@PathVariable int id) {
        this.roadServiceService.deleteById(id);
        return true;
    }

    @RequestMapping(
            method = {RequestMethod.PUT},
            path = {"/{id}"}
    )
    public Road update(@PathVariable int id, @RequestBody Road updateOrder) {
        Road existing = (Road) this.roadService.findbyId(id).get();
        existing.setCustomerId(updateOrder.getCustomerId());
        existing.setTotalPrice(updateOrder.getTotalPrice());
        existing.setShipName(updateOrder.getShipName());
        existing.setShipAddress(updateOrder.getShipAddress());
        existing.setShipPhone(updateOrder.getShipPhone());
        existing.setStatus(updateOrder.getStatus());
        this.orderService.save(existing);
        return updateOrder;
    }
}
