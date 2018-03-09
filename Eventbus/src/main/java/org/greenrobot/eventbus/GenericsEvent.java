package org.greenrobot.eventbus;

public class GenericsEvent<T> implements IGenericsEvent {
    //通过参数来记录当前post的GenericsEvent中T的类型，
    //在invoke之前来与Subscribe中设置的type是否一致
    //来决定是否invoke函数
    private final Class<T> mType;
    private T mData;
    public GenericsEvent(Class<T> type) {
        mType = type;
    }

    @Override
    public Class<?> getGenericsType() {
        return mType;
    }


    public void setData(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }
}