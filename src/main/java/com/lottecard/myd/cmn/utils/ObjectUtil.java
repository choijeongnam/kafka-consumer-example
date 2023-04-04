package com.lottecard.myd.cmn.utils;

public class ObjectUtil {
    /** Caller Class <code>CALL_CLASS</code> */
    public static final int CALL_CLASS   = 1;
    /** Caller Method <code>CALL_METHOD</code> */
    public static final int CALL_METHOD  = 2;
    /** Caller LineNumber <code>CALL_LINENUM</code> */
    public static final int CALL_LINENUM = 4;
    /**
     * 생성자
     */
    protected ObjectUtil() {
    }
    /**
     * Object의 Null Check
     *
     * @param tmpObject
     *            Null Check할 Object
     * @return Object가 null이면 true, instance화 되어 있으면 false
     */
    public static boolean isNull(Object tmpObject) {
        if (tmpObject == null) {
            return true;
        }
        return false;
    }
    /**
     * Object 배열의 Null Check
     *
     * @param tmpObject
     *            Null Check할 Object 배열
     * @return Object배열이 null이면 true, instance화 되어 있으면 false
     */
    public static boolean isArrayNull(Object[] tmpObject) {
        if (tmpObject == null || tmpObject.length < 1) {
            return true;
        }
        return false;
    }
}
