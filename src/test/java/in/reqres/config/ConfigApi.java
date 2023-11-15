package in.reqres.config;

import org.aeonbits.owner.Config;

@ConfigApi.Sources({
        "classpath:config.properties"
})
public interface ConfigApi extends Config {
    @Key("baseUri")
    String BaseUri();

    @Key("basePath")
    String BasePath();
}
