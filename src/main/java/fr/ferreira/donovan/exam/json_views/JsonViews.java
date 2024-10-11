package fr.ferreira.donovan.exam.json_views;

import fr.ferreira.donovan.exam.json_views.JsonViewsUser.*;
import fr.ferreira.donovan.exam.json_views.JsonViewsMap.*;
import fr.ferreira.donovan.exam.json_views.JsonViewsCoordinate.*;
import fr.ferreira.donovan.exam.json_views.JsonViewsGame.*;
import fr.ferreira.donovan.exam.json_views.JsonViewsRound.*;

public class JsonViews {

    public interface AllJsonViews {}

    public interface CoordinateShowJsonViews extends AllCoordinate {}

    public interface UserShowJsonViews extends AllUser {}

    public interface MapListJsonViews extends MinimalMap {}
    public interface MapShowJsonViews extends AllMap {}

    public interface RoundShowJsonViews extends AllRound {}

    public interface GameListJsonViews extends MinimalGame, MinimalUser {}
    public interface GameShowJsonViews extends AllGame, MinimalRound {}

    public interface Ignore {}
}
