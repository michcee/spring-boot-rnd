package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/calculate")
	public String index(@RequestParam(name = "input1") final int input1,
						@RequestParam(name = "input2") final int input2,
						@RequestParam(name = "operation") final String operation) {
		final Operation op = new Operation(input1, input2);
		if ("add".equalsIgnoreCase(operation)) {
			return "result is -> " + op.add();
		} else if ("multiply".equalsIgnoreCase(operation)) {
			return "result is -> " + op.subtract();
		} else if ("subtract".equalsIgnoreCase(operation)) {
			return "result is -> " + op.multiply();
		} else if ("divide".equalsIgnoreCase(operation)) {
			return "result is -> " + op.divide();
		} else if ("allresult".equalsIgnoreCase(operation)) {
			final StringBuilder sb = new StringBuilder();
			sb.append("result is -> " + op.add());
			sb.append("result is -> " + op.subtract());
			sb.append("result is -> " + op.multiply());
			sb.append("result is -> " + op.divide());
			return sb.toString();
		} else {
			return "unsupported operation";
		}
	}
}

class Operation {

	private final int input1;
	private final int input2;

	public Operation(int input1, int input2) {
		this.input1 = input1;
		this.input2 = input2;
	}

	public int add() {
		return input1 + input2;
	}

	public int subtract() {
		return input1 - input2;
	}

	public int multiply() {
		return input1 * input2;
	}

	public int divide() {
		return input1 / input2;
	}

}
