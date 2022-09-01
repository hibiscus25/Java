package B_ReadMe.B28_Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class LocalDat {
    public static void main(String[] args) {
        /*      Старый Java API для работы с датами был не потокобезопасный, поэтому приходилось думать о том,
             как уберечь себя от ошибок в многопоточной среде
                Новый Date/Time API содержит неизменные, потокобезопасные классы

                Список новых классов:
                    - LocalDate         –  дата без времени и временных зон
                    - LocalTime         –  время без даты и временных зон
                    - LocalDateTime     –  дата и время без временных зон
                    - ZonedDateTime     –  дата и время с временной зоной
                    - DateTimeFormatter –  форматирует даты в строки и наоборот, только для классов java.time
                    - Instant           –  количество секунд с Unix epoch time (полночь 1 января 1970 UTC)
                    - Duration          –  продолжительность в секундах и наносекундах
                    - Period            –  период времени в годах, месяцах и днях
                    - TemporalAdjuster  –  корректировщик дат (к примеру, может получить дату следующего понедельника)
         */



        System.out.println("---------- задать дату/время ----------");
        // now() - cтатический метод у LocalDate, LocalTime и LocalDateTime, возвращает текущую дату и время
        LocalDate now = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDT = LocalDateTime.now();
        System.out.println(now);                                // 2022-06-11
        System.out.println(nowTime);                            // 19:58:24.638
        System.out.println(nowDT);                              // 2022-06-11T19:58:24.638


        // задать нужную дату
        System.out.println("\n" + LocalDate.of(2022, Month.SEPTEMBER, 24));     // 2022-09-24
        System.out.println(LocalDate.of(2021, 1, 1));                    // 2021-01-01
        System.out.println(LocalDate.ofYearDay(2020, 361));                      // 2020-12-26


        // of(), ofSecondsOfDay(), ofNanoOfDay() - задать нужное время
        /*    - of()                -   перегружен и принимает часы, минуты + секунды + наносекунды.
              - ofSecondsOfDay()    -   принимает количество секунд с начала дня
              - ofNanoOfDay()       -   количество наносекунд
        */
        System.out.println("\n" + LocalTime.of(12, 10));                        // 12:10
        System.out.println(LocalTime.of(18, 15, 10));                    // 18:15:10
        System.out.println(LocalTime.of(23, 59, 59, 700));  // 23:59:59.000000700
        System.out.println(LocalTime.ofSecondOfDay(9_124));                                  // 02:32:04
        System.out.println(LocalTime.ofNanoOfDay(100_000_000_000L));                         // 00:01:40


        // задать нужную дату и время (поскольку LocalDateTime является объединением LocalDate и LocalTime - методы схожи)
        // 1992-08-24T12:00
        System.out.println("\n" + LocalDateTime.of(1992, Month.AUGUST, 24, 12, 0));
        // 2004-08-23T17:15:02
        System.out.println(LocalDateTime.of(2004, Month.AUGUST, 23, 17, 15, 2));
        // 2008-01-06T20:45:02.000000002
        System.out.println(LocalDateTime.of(2008, Month.JANUARY, 6, 20, 45, 2, 2));                         // 00:01:40
        System.out.println(LocalDateTime.of(2009, 1, 13, 9, 7));    // 2009-01-13T09:07
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));                         // 2018-01-20T09:19:48.603054



        System.out.println("\n---------- добавить/отнять дату/время ----------");
        // plus(), plusDays(), plusWeeks(), plusMonths() в LocalDate cлужат для добавления нескольких дней или чего-то другого
        /*  при добавлении к LocalDate всегда создается новый экземпляр класса т.к. все классы в API являются неизменяемыми
              - plus()    -   перегружен и принимает
                                - либо TemporalAmount (интерфейс - Duration, Period)
                                  либо количество того, что мы хотим добавить
                                - и ChronoUnit (enum, есть значение от NANOS до FOREVER)
                                     - не все ChronoUnit являются валидными для LocalDate
                                     - нельзя добавить время (секунды, минуты часы и тд.) и бесконечность
        */
        System.out.println(now.plusDays(2));                                    // now + 2 дня
        System.out.println(now.plusWeeks(1));                                   // now + 1 неделя
        System.out.println(now.plusMonths(3));                                  // now + 3 месяца
        System.out.println(now.plus(Period.ofDays(20)));                        // now + 20 дней
        System.out.println(now.plus(1, ChronoUnit.MILLENNIA));      // now + 1000 лет
        // можно использовать отрицательные числа
        System.out.println(now.plusDays(-1));                                   // now - 1 день


        // добавить к LocalTime можно от наносекунд до полудня
        //      - валидными ChronoUnit считаются только те, которые относятся ко времени, а не датам
        //      - например, при использовании ChronoUnit.DAYS мы получим UnsupportedTemporalTypeException
        System.out.println("\n" + nowTime.plusNanos(100_000));                        // nowTime + 100_000 наноСек
        System.out.println(nowTime.plusSeconds(20));                                  // nowTime + 20 сек
        System.out.println(nowTime.plusMinutes(20));                                  // nowTime + 20 мин
        System.out.println(nowTime.plusHours(6));                                     // nowTime + 6 час
        System.out.println(nowTime.plus(Duration.ofMillis(100)));                     // nowTime + 100 милиСек
        System.out.println(nowTime.plus(1, ChronoUnit.HALF_DAYS));        // nowTime + 1*12 часов


        // отнимание даты в LocalDate похоже с добавлением
        //          - по ChronoUnit действуют те же правила, что и для добавления
        System.out.println("\n" + now.minusDays(2));                                  // now - 2 дня
        System.out.println(now.minusWeeks(2));                                        // now - 1 неделя
        System.out.println(now.minusMonths(3));                                       // now - 3 месяца
        System.out.println(now.minus(Period.ofDays(20)));                             // now - 20 дней
        System.out.println(now.minus(1, ChronoUnit.MILLENNIA));        // now - 1000 лет
        // можно использовать отрицательные числа
        System.out.println(now.minusDays(-1));                                        // now + 1 день


        // отнимание в LocalTime похоже с добавлением
        System.out.println("\n" + nowTime.minusNanos(100_000));                        // nowTime - 100_000 наноСек
        System.out.println(nowTime.minusSeconds(20));                                  // nowTime - 20 сек
        System.out.println(nowTime.minusMinutes(20));                                  // nowTime - 20 мин
        System.out.println(nowTime.minusHours(6));                                     // nowTime - 6 час
        System.out.println(nowTime.minus(Duration.ofMillis(100)));                     // nowTime - 100 милиСек
        System.out.println(nowTime.minus(1, ChronoUnit.HALF_DAYS));     // nowTime - 1*12 часов


        //    добавление и отнимание в LocalDateTime такое же, так как методы по добавлению/отниманию просто делегируют
        // исполнение методам  из  LocalDate и LocalTime
        // добавление
        System.out.println("\n" + nowDT.plusNanos(780_000_000));
        System.out.println(nowDT.plusSeconds(59));
        System.out.println(nowDT.plusMinutes(5));
        System.out.println(nowDT.plusHours(3));
        System.out.println(nowDT.plusDays(7));
        System.out.println(nowDT.plusWeeks(3));
        System.out.println(nowDT.plusMonths(5));
        System.out.println(nowDT.plusYears(2));
        System.out.println(nowDT.plus(Period.ofWeeks(2)));
        System.out.println(nowDT.plus(1, ChronoUnit.DECADES));

        // отнимание
        System.out.println("\n" + nowDT.minusNanos(780_000_000));
        System.out.println(nowDT.minusSeconds(59));
        System.out.println(nowDT.minusMinutes(5));
        System.out.println(nowDT.minusHours(3));
        System.out.println(nowDT.minusDays(7));
        System.out.println(nowDT.minusWeeks(3));
        System.out.println(nowDT.minusMonths(5));
        System.out.println(nowDT.minusYears(2));
        System.out.println(nowDT.minus(Period.ofWeeks(2)));
        System.out.println(nowDT.minus(1, ChronoUnit.DECADES));



        System.out.println("\n---------- cравнение даты/времени ----------");
        // isAfter() и isBefore()  используются для сравнения в LocalDate
        LocalDate d2017_09_23 = LocalDate.of(2017, 9, 23);
        System.out.println(now.isAfter(d2017_09_23));                       // true
        System.out.println(d2017_09_23.isAfter(now));                   // false
        System.out.println(now.isBefore(d2017_09_23));                      // false
        System.out.println(d2017_09_23.isBefore(now));                  // true


        // isAfter() и isBefore()  используются для сравнения в LocalTime
        LocalTime t2HoursAfter = nowTime.plusHours(2);
        System.out.println("\n" + nowTime.isAfter(t2HoursAfter));           // true
        System.out.println(t2HoursAfter.isAfter(nowTime));              // false
        System.out.println(nowTime.isBefore(t2HoursAfter));                 // false
        System.out.println(t2HoursAfter.isBefore(nowTime));             // true


        // isAfter() и isBefore()  используются для сравнения в LocalDateTime
        LocalDateTime monthAgo = nowDT.minusMonths(1);
        System.out.println("\n" + nowDT.isAfter(monthAgo));                 // true
        System.out.println(monthAgo.isAfter(nowDT));                    // false
        System.out.println(nowDT.isBefore(monthAgo));                       // false
        System.out.println(monthAgo.isBefore(nowDT));                   // true

        // PS: во всех 3 классах при сравнениях используется метод compareTo(), который можно вызвать и самостоятельно



        System.out.println("\n---------- форматирование даты/времени ----------");
        // класс DateTimeFormatter умеет форматировать LocalDate, LocalTime, LocalDateTime
        // форматирование LocalDate (есть и другие Enum)
        System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));           // 20220611
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));                 // 2022-06-11
        System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));            // 2022-W23-6
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));           // 2022-06-11
        System.out.println(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));         // 2022-162
        // если нет нужно формата, можно задать свой
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));                         // 11 июн 2022
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.CHINA)));   // 11 六月 2022


        // форматирование LocalTime (есть и другие Enum)
        System.out.println("\n" + nowTime.format(DateTimeFormatter.ISO_LOCAL_TIME));     // 23:00:41.651
        System.out.println(nowTime.format(DateTimeFormatter.ISO_TIME));                  // 23:00:41.651
        // ISO_TIME в отличие от ISO_LOCAL_TIME  может включать временной сдвиг (offset), если он есть
        // если нет нужно формата, можно задать свой
        System.out.println(nowTime.format(DateTimeFormatter.ofPattern("hh:mm:ss ")));                       // 11:00:41
        System.out.println(nowTime.format(DateTimeFormatter.ofPattern("h:mm a")));                          // 11:00 PM
        System.out.println(nowTime.format(DateTimeFormatter.ofPattern("h:mm a", Locale.CHINA)));    // 11:00 下午


        // форматирование LocalDateTime
        System.out.println("\n" + nowDT.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(nowDT.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(nowDT.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(nowDT.format(DateTimeFormatter.ISO_LOCAL_DATE));
        // если нет нужно формата, можно задать свой
        System.out.println(nowDT.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss", Locale.CHINA)));



        System.out.println("\n---------- ZoneDateTime ----------");
        // cоздание ZonedDateTime
        ZonedDateTime zon = ZonedDateTime.now();
        System.out.println(zon);                            // 2022-06-11T23:06:30.263+03:00[Europe/Helsinki]

            LocalDate localDate = LocalDate.of(2018, 1, 1);
            LocalTime localTime = LocalTime.of(10, 30);
            ZoneId zone = ZoneId.of("Europe/Kiev");
        ZonedDateTime kievTime = ZonedDateTime.of(localDate, localTime, zone);
        System.out.println(kievTime);                       // 2018-01-01T10:30+02:00[Europe/Kiev]


        // withZoneSameInstant()  -     конвертация между временными зонами
        //   временную зону можно указывать с помощью ZoneId  или с помощью ZoneOffset, если вы не знаете id города/страны
        System.out.println("\n" + kievTime.withZoneSameInstant(ZoneId.of("America/New_York")));
        System.out.println(kievTime.withZoneSameInstant(ZoneOffset.of("-09:00")));


        // вернет все id временных зон, но без указания смещения (offset)
        //     new ArrayList<>(ZoneId.getAvailableZoneIds()).forEach(System.out::println);



        System.out.println("\n---------- Period/Duration ----------");
        // Period  - указывает временной промежуток между двумя датами

            // between() - узнает разницу между датами
                 /*     сейчас 2022.06.11     период 2023.11.29
                            - сразу возьмет  1 год    с 2022.06.11 - 2023.06.11
                            - потом месяцы   5 мес    с 06.11 - 11.11
                            - потом дни      18 дней  с 11.11 - 29.11
                */
                LocalDate nextBirthday = LocalDate.of(2023, 11, 29);
                Period period = Period.between(now, nextBirthday);
                    System.out.println("Period: " + period);            // P1Y5M18D   (означает 1 год  5мес 18 дней)
                    System.out.println("Days: " + period.getDays());    // 18 дней
                //PS: для такой задачи Period плохо подходит, так как самому нужно переводить год и месяцы в дни и считать


            // так же с Period можно переборщить
                Period period2 = Period.of(1, 15, 40);
                    System.out.println("\n" + period2);                 // P1Y15M40D
                    System.out.println(period2.getMonths());            // 15 (в периоде нет ограничений сколько месяц в году)
                    System.out.println(period2.getDays());              // 40 (в периоде нет ограничений сколько дней в месяце)


            // добавив метод normalized() немного улучшит ситуацию, но не то...
                Period period3 = Period.of(1, 15, 60).normalized();
                    System.out.println("\n" + period3);                 // P2Y3M60D
                    System.out.println(period3.getMonths());            // 3  (правильно посчитает месяцы)
                    System.out.println(period3.getDays());              // 60 (плохо посчитает дни)


            // можно использовать для добавления нужного периода времени к заданной дате
                LocalDate locPer = LocalDate.of(2018, 1, 1);
                    Period period4 = Period.of(1, 15, 60);
                    System.out.println("\n" + locPer.plus(period4));


        // Duration  - указывает временной промежуток между двумя датами, но измеряет все в часах, минутах, секундах
            // between() - узнает разницу между датами
                    LocalTime _10AM = LocalTime.of(10, 10,15);
                    LocalTime _9PM = LocalTime.of(21, 30);
                System.out.println("\n" + Duration.between(_10AM, _9PM));                     // PT11H19M45S


            // получение количества дней между датами
                // Duration не работает с LocalDate, но хорошо работает  с LocalDateTime
                //     - atStartOfDay() возвращает Duration
                //     - из Duration получаем количество дней
                    LocalDate locDt = LocalDate.of(2022, 6, 11);
                    LocalDate birthday = LocalDate.of(2023, 11, 29);
                Duration duration = Duration.between(locDt.atStartOfDay(), birthday.atStartOfDay());
                System.out.println("\n" + duration.toDays() + " дней");                       // 536


            // получение количества дней используя ChronoUnit
                long daysToBirth = ChronoUnit.DAYS.between(locDt, birthday);
                System.out.println(daysToBirth + " дней");                                   // 536



        System.out.println("\n---------- TemporalAdjusters ----------");
        // TemporalAdjusters - помогает решать различные специфические задачи с датой/временем
            LocalDate temp = LocalDate.of(2022, Month.JUNE, 14);

            // дата 4-го воскресенья в месяце
                TemporalAdjuster sunday = TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.SUNDAY);
                System.out.println(temp.with(sunday));                                                     // 2022-06-26

            // первый понедельник в месяце
                TemporalAdjuster firstMonInMonth = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
                System.out.println(temp.with(firstMonInMonth));                                            // 2022-06-06

            // количество дней до последней пятницы в месяце
                TemporalAdjuster lastFri = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
                Period un = temp.until(temp.with(lastFri));
                System.out.println(un.getDays());                                                           // 10

            // узнать все первое (даты)
                System.out.println(temp.with(TemporalAdjusters.firstDayOfMonth()));         // первый день в этом месяце
                System.out.println(temp.with(TemporalAdjusters.firstDayOfNextMonth()));     // первый день в след месяце
                System.out.println(temp.with(TemporalAdjusters.firstDayOfYear()));          // первый день в году
                System.out.println(temp.with(TemporalAdjusters.firstDayOfNextYear()));      // первый день в след году

            // последний день месяца / года
                System.out.println("\n" + temp.with(TemporalAdjusters.lastDayOfMonth()));   // 2022-06-30
                System.out.println(temp.with(TemporalAdjusters.lastDayOfYear()));           // 2022-12-31

            // cледующий вторник месяца
                // nextOrSame - если текущий день недели совпадает с желаемым, вернет его
                System.out.println("\n" + temp.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));   // 2022-06-14
                System.out.println(temp.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));            // 2022-06-07
                System.out.println(temp.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY)));      // 2022-06-14
    }
}
