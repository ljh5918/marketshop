package com.marketshop.marketshop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 1831347889L;

    public static final QItem item = new QItem("item");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemCategory = createString("itemCategory");

    public final StringPath itemDetail = createString("itemDetail");

    public final StringPath itemNm = createString("itemNm");

    public final EnumPath<com.marketshop.marketshop.constant.ItemSellStatus> itemSellStatus = createEnum("itemSellStatus", com.marketshop.marketshop.constant.ItemSellStatus.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<ItemImg, QItemImg> productThumbnails = this.<ItemImg, QItemImg>createList("productThumbnails", ItemImg.class, QItemImg.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> regTime = createDateTime("regTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> stockNumber = createNumber("stockNumber", Integer.class);

    public final NumberPath<Integer> wishlistCount = createNumber("wishlistCount", Integer.class);

    public final SetPath<Wishlist, QWishlist> wishlistItems = this.<Wishlist, QWishlist>createSet("wishlistItems", Wishlist.class, QWishlist.class, PathInits.DIRECT2);

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

