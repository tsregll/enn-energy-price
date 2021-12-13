package com.enn.energy.price.client.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 电价规则明细DTO.
 *
 * @author : wuchaon
 * @version : 1.0 2021/11/19 16:29
 * @since : 1.0
 **/
@Data
public class ElectricityPriceDetailDTO implements Serializable,Comparable<ElectricityPriceDetailDTO>  {

    private static final long serialVersionUID = 680834680137302654L;

    /**
     * 电价明细id
     */
    private String detailId;

    /**
     * 时段，0:尖;1:峰;2:平;3:谷
     */
    @ApiModelProperty(value = "时段", example = "0:尖;1:峰;2:平;3:谷")
    //@NotBlank(message = "时段必填")
    private String periods;

    /**
     * 时段开始时间
     */
    @ApiModelProperty(value = "开始时间", example = "11:00，到小时")
    //@NotBlank(message = "明细开始时间必填")
    private String startTime;

    /**
     * 时段结束时间
     */
    @ApiModelProperty(value = "结束时间", example = "11:00，到小时")
   // @NotBlank(message = "明细结束时间必填")
    private String endTime;

    /**
     * 阶梯定义
     */
    private String step;

    /**
     * 阶梯起码
     */
    private String startStep;

    /**
     * 阶梯止码
     */
    private String endStep;

    /**
     * 电价
     */
    @ApiModelProperty(value = "电价", required = true)
    @NotBlank(message = "电价必填")
    private String price;

    @Override
    public int compareTo(ElectricityPriceDetailDTO o) {
        return this.getStartTime().compareTo(o.getStartTime());
    }
}
