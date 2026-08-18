package data;

import io.quarkiverse.roq.frontmatter.runtime.model.DocumentPage;
import io.quarkus.qute.TemplateExtension;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

@TemplateExtension
public class SeasonHelper {

    public record SpeakerTalk(String speakerId, String talkTitle) {}

    // season format: "2025-2026" → September 2025 to July 2026
    static List<SpeakerTalk> seasonSpeakers(List<DocumentPage> pages, String season) {
        String[] years = season.split("-");
        LocalDate start = LocalDate.of(Integer.parseInt(years[0]), 9, 1);
        LocalDate end = LocalDate.of(Integer.parseInt(years[1]), 7, 31);
        return pages.stream()
                .filter(p -> {
                    LocalDate date = p.info().date().toLocalDate();
                    return !date.isBefore(start) && !date.isAfter(end);
                })
                .flatMap(p -> StreamSupport.stream(
                        p.data().getJsonArray("speakers").spliterator(), false)
                        .map(id -> new SpeakerTalk(id.toString(), p.data().getString("title"))))
                .toList();
    }

    static List<String> seasonSpeakerIds(List<DocumentPage> pages, String season) {
        String[] years = season.split("-");
        LocalDate start = LocalDate.of(Integer.parseInt(years[0]), 9, 1);
        LocalDate end = LocalDate.of(Integer.parseInt(years[1]), 7, 31);
        return pages.stream()
                .filter(p -> {
                    LocalDate date = p.info().date().toLocalDate();
                    return !date.isBefore(start) && !date.isAfter(end);
                })
                .sorted(Comparator.comparing(p -> p.info().date().toLocalDate()))
                .flatMap(p -> StreamSupport.stream(
                        p.data().getJsonArray("speakers").spliterator(), false)
                        .map(Object::toString))
                .distinct()
                .toList();
    }
}
