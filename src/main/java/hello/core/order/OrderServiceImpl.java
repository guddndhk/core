package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 필드주입
//    @Autowired private final MemberRepository memberRepository;
//    @Autowired private final DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // setter 주입
    // 스프링 라이플 사이클 상 스프링 컨테이너 빈 스캔후 Autowired 를 보고 해당 셋터를 주입한다.
    // 하지만 웃긴건 생성자 주입만 빈 등록과 동시에 주입도 한다.. 애초에 해당 객체를 사용하면 생성자를 생성해야 하니까.
    // 또한 선택적 의존관계 주입 가능 (required = false) 로 두면됨.

/*    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
 */

//    public OrderServiceImpl() {
//
//    }


    // 생성자가 하나일 경우 @Autowired 생략이 가능하다.
    // 하지만 나는 가독성을 위해 적어주는 편 이다. 현업에서는 안쓰는경우도 많아 지는 추세.
    // @RequiredArgsConstructor 로 대체
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
