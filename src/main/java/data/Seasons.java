package data;

import io.quarkiverse.roq.data.runtime.annotations.DataMapping;

import java.time.LocalDate;
import java.util.List;

@DataMapping(value = "seasons", parentArray = true)
public record Seasons(List<Season> list) {

    public record Season(String name, String endDate) {
        public boolean isOver() {
            return LocalDate.now().isAfter(LocalDate.parse(endDate));
        }
    }

    public Season current() {
        return list.getLast();
    }
}
