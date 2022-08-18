package whiteship.stack;

import static org.assertj.core.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("스택 기능 단위테스트")
class ArrayStackTest {

    ArrayStack arrayStack = new ArrayStack();

    @BeforeEach
    void setup() {
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
    }

    @AfterEach
    void init() {
        arrayStack.clear();
    }

    @Test
    @DisplayName("스택에 데이터를 push 할 수 있다.")
    void push() {
        // when
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);

        // then
        assertThat(arrayStack.get(3)).isEqualTo(4);
        assertThat(arrayStack.get(4)).isEqualTo(5);
        assertThat(arrayStack.get(5)).isEqualTo(6);
        assertThat(arrayStack.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("스택 데이터를 pop 할 수 있다.")
    void pop() {
        // when
        int v1 = arrayStack.pop();
        int v2 = arrayStack.pop();
        int v3 = arrayStack.pop();

        // then
        assertThat(v1).isEqualTo(3);
        assertThat(v2).isEqualTo(2);
        assertThat(v3).isEqualTo(1);
        assertThat(arrayStack.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("스택이 비어있을 때 pop 하면 EmptyStackException 예외가 발생한다.")
    void pop_exception() {
        // given
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();

        // when, then
        assertThatThrownBy(() -> arrayStack.pop())
            .isInstanceOf(EmptyStackException.class);
    }
}
