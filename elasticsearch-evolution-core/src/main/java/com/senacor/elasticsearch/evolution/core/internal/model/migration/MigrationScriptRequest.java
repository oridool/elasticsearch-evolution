package com.senacor.elasticsearch.evolution.core.internal.model.migration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents the HTTP request from the migration script
 *
 * @author Andreas Keefer
 */
public class MigrationScriptRequest {

    /**
     * http method,like POST, PUT or DELETE
     * non-null
     */
    private String httpMethod;

    /**
     * relative path to the endpoint without hostname, like /my_index
     * nullable
     */
    private String path;

    /**
     * additional http headers, like Content-Type: application/json
     * May be empty.
     */
    private Map<String, String> httpHeader = new HashMap<>();

    /**
     * HTTP body to send.
     * nullable.
     */
    private StringBuilder body = new StringBuilder();

    public MigrationScriptRequest() {
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public MigrationScriptRequest setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MigrationScriptRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public Map<String, String> getHttpHeader() {
        return httpHeader;
    }

    public MigrationScriptRequest setHttpHeader(Map<String, String> httpHeader) {
        this.httpHeader = httpHeader;
        return this;
    }

    public MigrationScriptRequest addHttpHeader(String header, String value) {
        this.httpHeader.put(header, value);
        return this;
    }

    public String getBody() {
        return body.toString();
    }

    public MigrationScriptRequest setBody(String body) {
        this.body = new StringBuilder(body);
        return this;
    }

    public MigrationScriptRequest addToBody(String bodyPart) {
        this.body.append(bodyPart);
        return this;
    }

    @Override
    public String toString() {
        return "MigrationScript{" +
                "httpMethod='" + httpMethod + '\'' +
                ", path='" + path + '\'' +
                ", httpHeader=" + httpHeader +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpMethod, path, httpHeader, body);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MigrationScriptRequest other = (MigrationScriptRequest) obj;
        return Objects.equals(this.httpMethod, other.httpMethod)
                && Objects.equals(this.path, other.path)
                && Objects.equals(this.httpHeader, other.httpHeader)
                && Objects.equals(this.body.toString(), other.body.toString());
    }

    public boolean isBodyEmpty() {
        return body.length() == 0;
    }
}
