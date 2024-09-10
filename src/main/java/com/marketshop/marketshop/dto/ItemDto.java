package com.marketshop.marketshop.dto;

import com.marketshop.marketshop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

// 메인화면에 상품 상태 표시
import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {

    private Long id;

    private String itemNm;

    private String itemCategory;

    private ItemSellStatus itemSellStatus;

    private Integer price;

    private String itemDetail;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
