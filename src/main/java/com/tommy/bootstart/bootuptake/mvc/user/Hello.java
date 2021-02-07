package com.tommy.bootstart.bootuptake.mvc.user;

import org.springframework.hateoas.EntityModel;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * RestApi HATEOAS
 * 공식 레퍼런스에서는 public class Hello extends EntityModel<Hello> 의 형태로 상속을 해서 접근하라는 문구가 있었다.
 * 하지만 UserController 에서 정적 팩토리 메서드로 초기화를 해주는데 extends EntityModel 로 의존성을 갖게 해줄 필요가 있을까?
 * 하여 의존성을 제거했다. 작동하는데 문제는 없다.
 * HATEOAS 의 사용방법이 많이 바뀌었다. 실 적용할때는 공식 레퍼런스를 잘 보고 도입해야 할 것 같다.
 */
public class Hello {

    private final String prefix;
    private final String name;

    public Hello(String prefix, String name) {
        this.prefix = prefix;
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return prefix + " " + name;
    }
}
