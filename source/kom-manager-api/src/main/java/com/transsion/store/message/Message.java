package com.transsion.store.message;

public interface Message {

	public enum Group{
		TASK,
		USER
	};
	public enum Type{
		//task group
		TASK_SALE_IMPORT(100,"TASK_SALE_IMPORT"),
		TASK_GOAL_IMPORT(101,"TASK_GOAL_IMPORT");
		//user
		
		private int value;
		private String desc;

		private Type(int value, String desc) {
			this.setValue(value);
			this.setDesc(desc);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		@Override
		public String toString() {
			return "[" + this.value + "]" + this.desc;
		}
	};
	
}
