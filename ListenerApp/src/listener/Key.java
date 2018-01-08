package listener;

public class Key {
	private int id;
	
	private int value;
	
	private int count;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Button [id=");
		builder.append(id);
		builder.append(", value=");
		builder.append(value);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Key other = (Key) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
