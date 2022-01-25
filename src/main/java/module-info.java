import be.technifutur.demineurApp.DemineurFactory;
import be.technifutur.java2021.api.ApplicationFactory;

module DemineurProject {
    requires myFrameWork;
    provides ApplicationFactory with DemineurFactory;
}