package whiteship.stack;

import static org.assertj.core.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("스택 기능 단위테스트")
class StackTest {

    Stack stack = new Stack();

    @BeforeEach
    void setup() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @AfterEach
    void init() {
        stack.clear();
    }

    @Test
    @DisplayName("스택에 데이터를 추가할 수 있다.")
    void push() {
        // when
        stack.push(4);
        stack.push(5);
        stack.push(6);

        // then
        assertThat(stack.get(3)).isEqualTo(4);
        assertThat(stack.get(4)).isEqualTo(5);
        assertThat(stack.get(5)).isEqualTo(6);
        assertThat(stack.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("스택 데이터를 pop 할 수 있다.")
    void pop() {
        // when
        int v1 = stack.pop();
        int v2 = stack.pop();
        int v3 = stack.pop();

        // then
        assertThat(v1).isEqualTo(3);
        assertThat(v2).isEqualTo(2);
        assertThat(v3).isEqualTo(1);
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("스택이 비어있을 때 pop 하면 EmptyStackException 예외가 발생한다.")
    void pop_exception() {
        // given
        stack.pop();
        stack.pop();
        stack.pop();

        // when, then
        assertThatThrownBy(() -> stack.pop())
            .isInstanceOf(EmptyStackException.class);
    }
}
