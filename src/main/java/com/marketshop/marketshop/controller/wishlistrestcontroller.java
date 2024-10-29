package com.marketshop.marketshop.controller;

import com.marketshop.marketshop.entity.Item;
import com.marketshop.marketshop.service.WishlistItemResponse;
import com.marketshop.marketshop.service.WishlistResponse;
import com.marketshop.marketshop.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@RestController
@RequestMapping("/wishlist")
public class wishlistrestcontroller {

    @Autowired
    private WishlistService wishlistService;

    // Add or remove an item from the wishlist
    @PostMapping("/add")
    public ResponseEntity<WishlistResponse<String>> addWishlist(
            @RequestParam("memberId") Long memberId,
            @RequestParam("itemId") Long itemId) {
        try {
            String message = wishlistService.toggleWishlist(memberId, itemId);
            return new ResponseEntity<>(new WishlistResponse<>(message, null), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new WishlistResponse<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    // Retrieve a user's wishlist by their memberId
    // 특정 회원의 찜 목록 조회
    @GetMapping("/user")
    public ResponseEntity<WishlistResponse<List<WishlistItemResponse>>> getUserWishlist(@RequestParam("memberId") Long memberId) {
        List<WishlistItemResponse> wishlist = wishlistService.getWishlist(memberId);
        return new ResponseEntity<>(new WishlistResponse<>("찜 목록", wishlist), HttpStatus.OK);
    }
}

//@RestController
//@RequestMapping("/wishlist")
//public class wishlistrestcontroller {
//    @Autowired
//    WishlistService wishlistService;
//
//    @PostMapping("/add")
////    public ResponseEntity<WishlistResponse<String>> addwishlist(@RequestParam Long memberId, @RequestParam Long itemId) {
//        String message = wishlistService.toggleWishlist(memberId, itemId);
//        return new ResponseEntity<>(new WishlistResponse<>(message, null), HttpStatus.OK);
//    }
//    @GetMapping("/user/{memberId}")
//    public ResponseEntity<WishlistResponse<List<Item>>> getuserwishlist(@PathVariable Long memberId){
//        List<Item> wishlist = wishlistService.getWishllist(memberId);
//        System.out.println(wishlistService.getWishllist(4L));
//        return new ResponseEntity<>(new WishlistResponse<>( "찜 목록", wishlist), HttpStatus.OK);
//    }
//
//}



//@RestController
//@RequestMapping("/wishlist")
//public class wishlistrestcontroller {
//
//    @Autowired
//    WishlistService wishlistService;
//
//    @PostMapping("/add")
//    public ResponseEntity<?> addToWishlist(@RequestParam(name = "memberId") Long memberId,
//                                           @RequestParam(name = "itemId") Long itemId,
//                                           Authentication authentication) {
//        String message = wishlistService.toggleWishlist(memberId, itemId);
//        return new ResponseEntity<>(new WishlistResponse<>(message, null), HttpStatus.OK);
//    }
//
//
//@GetMapping("/user/{memberId}")
//public ResponseEntity<WishlistResponse<List<Item>>> getUserWishlist(@PathVariable(name = "memberId") Long memberId) {
//    List<Item> wishlist = wishlistService.getWishllist(memberId);
//    return new ResponseEntity<>(new WishlistResponse<>("찜 목록", wishlist), HttpStatus.OK);
//}
//
//}


//
//@RestController
//@RequestMapping("/wishlist")
//public class wishlistrestcontroller {
//
//    @Autowired
//    private WishlistService wishlistService;
//
//    // 찜 목록에 아이템 추가/제거
//    @PostMapping("/add")
//    public ResponseEntity<WishlistResponse<String>> addWishlist(
//            @RequestParam("memberId") Long memberId,
//            @RequestParam("itemId") Long itemId) {
//        String message = wishlistService.toggleWishlist(memberId, itemId);
//        return new ResponseEntity<>(new WishlistResponse<>(message, null), HttpStatus.OK);
//    }
//
//    // 특정 회원의 찜 목록 조회
//    @GetMapping("/user/{memberId}")
//    public ResponseEntity<WishlistResponse<List<WishlistItemResponse>>> getUserWishlist(@PathVariable Long memberId) {
//        List<WishlistItemResponse> wishlist = wishlistService.getWishlist(memberId);
//        return new ResponseEntity<>(new WishlistResponse<>("찜 목록", wishlist), HttpStatus.OK);
//    }
//}
