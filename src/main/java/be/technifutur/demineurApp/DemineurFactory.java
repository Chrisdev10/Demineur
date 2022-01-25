package be.technifutur.demineurApp;

import be.technifutur.java2021.api.Application;
import be.technifutur.java2021.api.ApplicationFactory;

public class DemineurFactory implements ApplicationFactory {
    @Override
    public Application getApplication() {
        return new DemineurApp();
    }


}
