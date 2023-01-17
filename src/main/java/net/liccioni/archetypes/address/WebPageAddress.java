package net.liccioni.archetypes.address;

/**
 * @generated
 */
public class WebPageAddress extends Address {

    /**
     * @generated
     */
    private String url;


    /**
     * @generated
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @generated
     */
    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String getAddress() {
        return this.url;
    }
}
