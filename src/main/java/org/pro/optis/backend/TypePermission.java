package org.pro.optis.backend;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TypePermission {
    ADMIN_CREATE,
    ADMIN_READ,
    ADMIN_UPDATE,
    ADMIN_DELETE,

    TESTER_CREATE,

    TESTER_READ,
    TESTER_UPDATE,
    TESTER_DELETE_AVIS,

    USER_PREDICTION,

    USER_LOGGER, USER_CREATE_USER;

    private String permission;
}