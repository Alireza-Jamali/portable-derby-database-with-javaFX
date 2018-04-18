package view;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

/**
 *
 * @author AezA
 */
public class CenteredAlignedCallback extends TextFieldTableCell {

    public static <S> Callback<TableColumn<S, String>, TableCell<S, String>> forTableColumnCenteredAligned() {
        return forTableColumnCenteredAligned(new DefaultStringConverter());
    }

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumnCenteredAligned(
            final StringConverter<T> converter) {
        return (TableColumn<S, T> list) -> {
            TextFieldTableCell<S, T> textField = new TextFieldTableCell(converter);
            textField.setAlignment(Pos.CENTER);
            return textField;
        };
    }
    
    public static <S> Callback<TableColumn<S, String>, TableCell<S, String>> forTableColumnCenteredAlignedT() {
        return forTableColumnCenteredAlignedT(new DefaultStringConverter());
    }

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumnCenteredAlignedT(
            final StringConverter<T> converter) {
        return (TableColumn<S, T> list) -> {
            TextFieldTableCell<S, T> textField = new TextFieldTableCell(converter);
            textField.setAlignment(Pos.CENTER);
            return textField;
        };
    }
}