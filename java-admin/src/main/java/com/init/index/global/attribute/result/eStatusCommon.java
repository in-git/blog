package com.init.index.global.attribute.result;
/*
      -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
      --------->    返回普通状态信息
      -*-*-*-*- -*-*-*-*- -*-*-*-*- -*-*-*-*-
  */
public enum eStatusCommon {
    SUCCESS( 1 , "成功" ), ERROR( -1 , "失败" ), NORMAL( 0 , "收到消息" );
    private Integer status;
    private String msg;

    eStatusCommon ( int status , String msg ) {
        this.msg =msg;
        this.status = status;
    }

    public Integer getStatus ( ) {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public String getMsg ( ) {
        return msg;
    }

    public void setMsg ( String msg ) {
        this.msg = msg;
    }
}
