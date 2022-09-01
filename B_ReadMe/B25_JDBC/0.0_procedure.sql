-- при запуске добавляет в Database в папку routines
        # create PROCEDURE JDBCount (OUT CNT INT)
        # BEGIN
        #     SELECT COUNT(*) INTO CNT FROM JDBC1;
        # END

-- call JDBCount (@out);
    -- SELECT @out;
# ---------------------------------------------------------------------------

        # create PROCEDURE getBooks(bookId INT)
        # BEGIN
        #     SELECT * FROM JDBC1 where id = bookId;
        # END

-- call getBooks(1);
# ---------------------------------------------------------------------------

        # create PROCEDURE getCount()
        # BEGIN
        #     SELECT COUNT(*) FROM ITEMS;
        #     SELECT COUNT(*) FROM JDBC1;
        # END

-- call getCount();
    -- SELECT @items;
    -- SELECT @jdbc1;
# ---------------------------------------------------------------------------