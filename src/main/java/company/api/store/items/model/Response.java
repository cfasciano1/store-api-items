package company.api.store.items.model;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1920456413231028987L;
	
	private T payload;
	private String errorMessage;
	
	public Response() {
		this.payload = null;
		this.errorMessage = null;
	}
	
	public Response(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Response(T payload) {
		this.payload = payload;
	}
	
	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response<?> other = (Response<?>) obj;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Response [payload=" + payload + ", errorMessage=" + errorMessage + "]";
	}

}
