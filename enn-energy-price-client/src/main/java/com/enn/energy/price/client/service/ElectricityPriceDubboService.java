package com.enn.energy.price.client.service;

import com.enn.energy.price.client.dto.request.ElectricityPriceVersionDTO;
import com.enn.energy.price.client.dto.request.ElectricityPriceVersionDelDTO;
import com.enn.energy.price.client.dto.request.ElectricityPriceVersionUpdateDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import top.rdfa.framework.biz.ro.RdfaResult;

/**
 * 罗森电价同步接口.
 *
 * @author : wuchaon
 * @version : 1.0 2021/11/19 16:38
 * @since : 1.0
 **/
//@FeignClient(name = "ENN-SALE-PLATFORM-PRICE")
public interface ElectricityPriceDubboService {

    @PostMapping(value = "/addElectricityPrice")
    @ApiOperation("新增自定义电价版本")
    RdfaResult<String> addElectricityPrice(ElectricityPriceVersionDTO electricityPriceVersionDTO);

    @PostMapping(value = "/updateElectricityPrice")
    @ApiOperation("修改自定义电价版本")
    RdfaResult<String> updateElectricityPrice(ElectricityPriceVersionUpdateDTO electricityPriceVersionUpdateDTO);

    @PostMapping(value = "/delElectricityPrice")
    @ApiOperation("删除自定义电价版本(未来版本)")
    RdfaResult<String> delElectricityPrice(ElectricityPriceVersionDelDTO delDTO);

    @PostMapping(value = "/delElectricityPriceForCommon")
    @ApiOperation("删除自定义电价版本(通用)")
    RdfaResult<String> delElectricityPriceForCommon(ElectricityPriceVersionDelDTO delDTO);
}
