package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;


class DemoApplicationTests {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	private StudentService studentService;

	@DisplayName("Should pass a non-null message to our test method")
	@ParameterizedTest(name = "{index} => message=''{0}''")
	@ValueSource(strings = {"Hello", "World"})
	void shouldPassNonNullMessageAsMethodParameter(String message) {
		assertNotNull(message);
	}

	@DisplayName("Should calculate the correct sum")
	@ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
	@CsvSource({
			"1, 1, 2",
			"2, 3, 5"
	})
	void sum(int a, int b, int sum) {
		assertEquals(sum, a + b);
	}

	@Test
	public void deleteStudentWithNoIDThrowsException(){
		Student student = new Student("name", "email@gmail.com", LocalDate.of(2006, Month.JANUARY, 5));
		assertThrows(NullPointerException.class,
				()->{
					studentService.deleteStudent(student.getId());
				});
	}

}
