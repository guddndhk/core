package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 기존 정보 코드를 남기기 위해 excludeFilters 룰 사용함.
@ComponentScan(
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 빈의 중복 상황 (수동, 자동) 등록시 수동이 우선권을 가짐
    // 개발자가 의도를 가지고 이런 상황을 연출 한다면 좋겠지만 대부분의 개발상은 의도적으로 만든 경우보다는 여러 설정이 꼬여서
    // 만들어지는 경우가 대부분이다 그렇기에 최근의 스트링 부트에서는 수동 및 자동 빈 등록시 충돌이 생긴다면 오류가 발생하도록
    // 기본값을 바꾸었다 그 설정을 application.properties 에서 디폴트 값을 변경 해줄수 있다.
    // 어설픈 추상화 보다는 명확성을 추구하자.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
