package com.lidd.littleApp.app.models;


public class Result {
	/**
	 * 通信标志。
	 * status==true,表示有进入到对应业务的controller内部
	 * status==false,表示没有进入到对应业务的controller内部。如IP被封、被拦截器拦截。
	 * 
	 * 针对所有的请求一定会返回 status,errorCode,errorMessage,dto 这四个个字段
	 */
    private boolean status = true;
    private int errorCode;
    private Object errorMessage;
    private Object dto;
	
	public Result(boolean status,int errorCode,Object errorMessage,Object dto){
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.dto = dto;
	}

	public boolean isStatus() {
		return status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public Object getErrorMessage() {
		return errorMessage;
	}

	public Object getDto() {
		return dto;
	}
	
	/**
	 * 公用的一些错误码
	 * @author taoguba
	 *
	 */
	public enum ERRORCODE{
		/**
		 * 未登录
		 */
		ERRORCODE_5001,
		/**
		 * 服务端出现异常
		 */
		ERRORCODE_4001,						
		/**
		 * 未激活
		 */
		ERRORCODE_6001,						
		/**
		 * 未设置笔名
		 */
		ERRORCODE_5004,						
		/**
		 * IP被禁用
		 */
		ERRORCODE_302;						
		
		/**
		 * 获取公共错误验证码
		 * @return
		 */
		public int getErrorCode(){
			switch(this){
				case ERRORCODE_5001: return 5001;
				case ERRORCODE_4001: return 4001;
				case ERRORCODE_6001: return 6001;
				case ERRORCODE_5004: return 5004;
				case ERRORCODE_302:  return 302;
				default: return 0;
			}
		}
	}
}
