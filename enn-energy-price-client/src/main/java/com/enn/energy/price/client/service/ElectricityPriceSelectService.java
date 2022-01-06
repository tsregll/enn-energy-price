package com.enn.energy.price.client.service;

import com.enn.energy.price.client.dto.request.*;
import com.enn.energy.price.client.dto.response.ElectricityPricePointDetailRespDTO;
import com.enn.energy.price.client.dto.response.ElectricityPriceValueDetailRespDTO;
import com.enn.energy.price.client.dto.response.ElectricityPriceVersionDetailRespDTO;
import com.enn.energy.price.client.dto.response.ElectricityPriceVersionsRespDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import top.rdfa.framework.biz.ro.PagedRdfaResult;
import top.rdfa.framework.biz.ro.RdfaResult;

import java.text.ParseException;

/**
 * 价格、版本等相关查询
 */
@FeignClient(name = "ENN-ENERGY-PRICE")
public interface ElectricityPriceSelectService {
    /**
     * 查询电价
     * @param electricityPriceValueReqDTO
     * @return
     */
    @PostMapping(value = "/price/electricityPrice")
    @ApiOperation("自定义电价查询")
    RdfaResult<ElectricityPriceValueDetailRespDTO> selectElePrice(ElectricityPriceValueReqDTO electricityPriceValueReqDTO);

    /**
     * 根据测点查询某天电价
     * @param cimPointPriceReq
     * @return
     */
    @PostMapping(value = "/price/pointRecord")
    @ApiOperation("根据测点查询某天电价")
    RdfaResult<ElectricityPricePointDetailRespDTO> pointRecord(ElectricityCimPointPriceReq cimPointPriceReq);

    /**
     * 查询版本列表
     * @param versionsReqDTO
     * @return
     */
    @PostMapping(value = "/price/selectVersions")
    @ApiOperation("自定义电价版本列表查询")
    PagedRdfaResult<ElectricityPriceVersionsRespDTO> selectVersions(ElectricityPriceVersionsReqDTO versionsReqDTO) throws ParseException;

    /**
     * 查询版本详情
     * @param detailReqDTO
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/price/versionDetail")
    @ApiOperation("自定义电价版本详情信息查询")
    RdfaResult<ElectricityPriceVersionDetailRespDTO> versionDetail(ElectricityPriceVersionDetailReqDTO detailReqDTO) throws Exception;

    @PostMapping(value = "/price/currentVersionDetail")
    @ApiOperation("自定义电价版本(当前生效)详情")
    RdfaResult<ElectricityPriceVersionDetailRespDTO> currentVersionDetail(ElectricityPriceCurrentVersionDetailReqDTO reqDTO);


}
