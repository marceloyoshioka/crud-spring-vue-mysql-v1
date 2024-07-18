package br.gov.pa.saude.api.exceptionhandler;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}

	public NegocioException(String message, IllegalArgumentException illegalArgumentException) {
		super(message, illegalArgumentException);
	}

}
