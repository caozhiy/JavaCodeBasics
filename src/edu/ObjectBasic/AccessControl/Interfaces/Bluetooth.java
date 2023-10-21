package edu.ObjectBasic.AccessControl.Interfaces;

public interface Bluetooth extends USB {
    default boolean connect(USB usb, String version) {
        return usb.version.compareTo(version) < 0;
    }

    // 重写了接口 USB 中的 getStatus
    boolean getStatus();

    boolean breakConnect();
}
