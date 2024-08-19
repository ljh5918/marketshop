package com.marketshop.marketshop.repository;

import com.marketshop.marketshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

// 장바구니 담기
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByMemberId(Long memberId);
}
