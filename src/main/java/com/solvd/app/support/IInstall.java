package com.solvd.app.support;

import com.solvd.app.exceptions.FireWallException;


public interface IInstall {
    void install(String pathname) throws FireWallException;
}
