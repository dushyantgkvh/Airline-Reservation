package com.wittybrains.ars.exception;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = BadRequestException.class)
	private ResponseEntity<ExceptionBody> handelBadRequestException(BadRequestException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ForbiddenException.class)
	private ResponseEntity<ExceptionBody> handelForbiddenException(ForbiddenException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = NotFoundException.class)
	private ResponseEntity<ExceptionBody> handleNotFoundException(NotFoundException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	private ResponseEntity<ExceptionBody> handelUnauthorizedException(UnauthorizedException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = UnprocessableEntityException.class)
	private ResponseEntity<ExceptionBody> handleUnprocessableEntityException(UnprocessableEntityException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(value = Exception.class)
	private ResponseEntity<ExceptionBody> handleException(Exception exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage(), DateTime.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	class ExceptionBody {
		private String message;
		private DateTime timeStamp;

		public ExceptionBody() {
		}

		public ExceptionBody(String message, DateTime timeStamp) {
			this.message = message;
			this.timeStamp = timeStamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public DateTime getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(DateTime timeStamp) {
			this.timeStamp = timeStamp;
		}

		@Override
		public String toString() {
			return "ExceptionBody [message=" + message + ", timeStamp=" + timeStamp + "]";
		}

	}
}
