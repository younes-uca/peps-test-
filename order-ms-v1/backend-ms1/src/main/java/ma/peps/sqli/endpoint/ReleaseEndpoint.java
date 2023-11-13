package ma.peps.sqli.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Endpoint(id = "release")
public class ReleaseEndpoint {

    private List<Version> versions = Stream.of(
                    new Version("1.1", "* Feature 3\n" +"* Feature 4\n" + "*  Feature 5\n" + "* Bug Fix 2\n"),
                    new Version("1.0", "* Feature 1\n" + "*  Feature 2\n" + "* Bug Fix 1\n")
            )
            .collect(Collectors.toList());


    @ReadOperation
    public String releaseNotes() {
        String result = "";
        if (versions != null) {
            for (Version version : versions) {
                result += version.toString() + "\n\n";
            }
        }
        return result;
    }

    @ReadOperation
    public String selectReleaseNotes(@Selector String selector) {
        String result = null;
        Version version = findByCode(selector);
        if (version != null) {
            return version.toString();
        } else return releaseNotes();
    }

    private Version findByCode(String code) {
        Version result = null;
        if (versions != null) {
            result = versions.stream().filter(e -> e.code.equals(code)).findFirst().orElse(null);
        }
        return result;
    }

    class Version {
        public String code;
        public String description;

        public Version(String code, String description) {
            this.code = code;
            this.description = description;
        }

        @Override
        public String toString() {
            return this.code + "\n\n" + this.description;
        }
    }

}
