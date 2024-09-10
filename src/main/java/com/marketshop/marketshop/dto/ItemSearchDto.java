package com.marketshop.marketshop.dto;

import com.marketshop.marketshop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

// 상품 조회 조건
@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchItemCategory;

    private String searchBy;

    private String searchQuery = "";
}
