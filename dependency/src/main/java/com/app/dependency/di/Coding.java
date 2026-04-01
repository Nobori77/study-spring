package com.app.dependency.di;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
// @Data: getter, setter, toString, equals, hashCode
// @NoArgsConstructor : 기본 생성자
// @AllArgsConstructor : 초기화 생성자
// @Getter : getter
// @Setter : setter
// @ToString : string
// @EqualsAndHashCode : equals. hashCode

public class Coding {

//    필드 주입을 하면 안되는 이유
//    1. 불변 상태를 만들수 없다.
//    final로 해결 X
//    2. 순환 참조 발생 여부를 알 수 없다.
//    서버 -> 코딩 -> 컴퓨터 -> 코딩 -> 컴퓨터

//    사용하면 안됨.
//    @Autowired
//    final private Computer computer;

//    setter 주입 안됨
//    final private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//    생성자 주입으로 불변성을 유지하자 !
    final private Computer computer;

    private String type;
    private String content;




}
