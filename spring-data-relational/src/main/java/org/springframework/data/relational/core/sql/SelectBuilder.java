package org.springframework.data.relational.core.sql;

import java.util.Collection;

/**
 * Entry point to construct a {@link Select} statement.
 *
 * @author Mark Paluch
 */
public interface SelectBuilder {

	/**
	 * Apply a {@code TOP} clause given {@code count}.
	 *
	 * @param count the top count.
	 * @return {@code this} {@link SelectBuilder}.
	 * @see SelectTop
	 */
	SelectBuilder top(int count);

	/**
	 * Include an arbitrary {@code sql} select list item. The {@code sql} is encapsulated into a simple {@link Expression}.
	 *
	 * @param sql the select list item.
	 * @return {@code this} builder.
	 * @see SQL#column(String)
	 */
	SelectAndFrom select(String sql);

	/**
	 * Include a {@link Expression} in the select list.
	 *
	 * @param expression the expression to include.
	 * @return {@code this} builder.
	 * @see SQL#column(String)
	 * @see Table#column(String)
	 */
	SelectAndFrom select(Expression expression);

	/**
	 * Include one or more {@link Expression}s in the select list.
	 *
	 * @param expressions the expressions to include.
	 * @return {@code this} builder.
	 * @see SQL#column(String)
	 * @see Table#columns(String...)
	 */
	SelectAndFrom select(Expression... expressions);

	/**
	 * Include one or more {@link Expression}s in the select list.
	 *
	 * @param expressions the expressions to include.
	 * @return {@code this} builder.
	 * @see SQL#column(String)
	 * @see Table#columns(String...)
	 */
	SelectAndFrom select(Collection<? extends Expression> expressions);

	/**
	 * Builder exposing {@code select} and {@code from} methods.
	 */
	interface SelectAndFrom extends SelectFrom {

		/**
		 * Include an arbitrary {@code sql} select list item. The {@code sql} is encapsulated into a simple {@link Expression}. Multiple calls to this or other {@code select} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param sql the select list item.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 */
		SelectFrom select(String sql);

		/**
		 * Include a {@link Expression} in the select list. Multiple calls to this or other {@code select} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param expression the expression to include.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectFrom select(Expression expression);

		/**
		 * Include one or more {@link Expression}s in the select list.  Multiple calls to this or other {@code select} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param expressions the expressions to include.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#columns(String...)
		 */
		SelectFrom select(Expression... expressions);

		/**
		 * Include one or more {@link Expression}s in the select list.  Multiple calls to this or other {@code select} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param expressions the expressions to include.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#columns(String...)
		 */
		SelectFrom select(Collection<? extends Expression> expressions);

		/**
		 * Declare a {@link Table} to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param table the table to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Table table);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Table... tables);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Collection<? extends Table> tables);
	}

	/**
	 * Builder exposing {@code from} methods.
	 */
	interface SelectFrom extends BuildSelect {

		/**
		 * Declare a {@link Table} to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param table the table name to {@code SELECT … FROM} must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		SelectFrom from(String table);

		/**
		 * Declare a {@link Table} to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param table the table to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		SelectFrom from(Table table);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		SelectFrom from(Table... tables);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		SelectFrom from(Collection<? extends Table> tables);
	}

	interface SelectFromAndJoin extends SelectFrom, BuildSelect, SelectJoin, SelectWhere, SelectLimitOffset {

		/**
		 * Declare a {@link Table} to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param table the table to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Table table);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Table... tables);

		/**
		 * Declare one or more {@link Table}s to {@code SELECT … FROM}.
		 * Multiple calls to this or other {@code from} methods keep adding items to the select list and do not replace previously contained items.
		 *
		 * @param tables the tables to {@code SELECT … FROM} must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see From
		 * @see SQL#table(String)
		 */
		@Override
		SelectFromAndJoin from(Collection<? extends Table> tables);

		/**
		 * Apply {@code limit} and {@code offset} parameters to the select statement.
		 * To read the first 20 rows from start use {@code limitOffset(20, 0)}. to read the next 20 use {@code limitOffset(20, 20)}.
		 *
		 * @param limit rows to read.
		 * @param offset row offset, zero-based.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin limitOffset(long limit, long offset);

		/**
		 * Apply a limit of rows to read.
		 *
		 * @param limit rows to read.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin limit(long limit);

		/**
		 * Apply an offset where to start reading rows.
		 *
		 * @param offset start offset.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin offset(long offset);
	}

	/**
	 * Builder exposing join/where/and {@code JOIN … ON} continuation methods.
	 */
	interface SelectFromAndJoinCondition extends BuildSelect, SelectJoin, SelectWhere, SelectOnCondition, SelectLimitOffset {

		/**
		 * Apply {@code limit} and {@code offset} parameters to the select statement.
		 * To read the first 20 rows from start use {@code limitOffset(20, 0)}. to read the next 20 use {@code limitOffset(20, 20)}.
		 *
		 * @param limit rows to read.
		 * @param offset row offset, zero-based.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin limitOffset(long limit, long offset);

		/**
		 * Apply a limit of rows to read.
		 *
		 * @param limit rows to read.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin limit(long limit);

		/**
		 * Apply an offset where to start reading rows.
		 *
		 * @param offset start offset.
		 * @return {@code this} builder.
		 */
		SelectFromAndJoin offset(long offset);
	}

	/**
	 * Limit/offset methods.
	 */
	interface SelectLimitOffset {

		/**
		 * Apply {@code limit} and {@code offset} parameters to the select statement.
		 * To read the first 20 rows from start use {@code limitOffset(20, 0)}. to read the next 20 use {@code limitOffset(20, 20)}.
		 *
		 * @param limit rows to read.
		 * @param offset row offset, zero-based.
		 * @return {@code this} builder.
		 */
		SelectLimitOffset limitOffset(long limit, long offset);

		/**
		 * Apply a limit of rows to read.
		 *
		 * @param limit rows to read.
		 * @return {@code this} builder.
		 */
		SelectLimitOffset limit(long limit);

		/**
		 * Apply an offset where to start reading rows.
		 *
		 * @param offset start offset.
		 * @return {@code this} builder.
		 */
		SelectLimitOffset offset(long offset);
	}

	/**
	 * Builder exposing {@code ORDER BY} methods.
	 */
	interface SelectOrdered extends BuildSelect {

		/**
		 * Add an order by {@code field} using default sort semantics.
		 *
		 * @param field field name, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see OrderByField#create(String)
		 */
		SelectOrdered orderBy(String field);

		/**
		 * Add one or more {@link Column columns} to order by.
		 *
		 * @param columns the columns to order by.
		 * @return {@code this} builder.
		 * @see OrderByField#create(String)
		 */
		SelectOrdered orderBy(Column... columns);

		/**
		 * Add an order by field using {@code indexes} using default sort semantics.
		 *
		 * @param indexes field indexes as declared in the select list.
		 * @return {@code this} builder.
		 * @see OrderByField#index(int)
		 */
		SelectOrdered orderBy(int... indexes);

		/**
		 * Add one or more {@link OrderByField order by fields}.
		 *
		 * @param orderByFields the fields to order by.
		 * @return {@code this} builder.
		 * @see OrderByField#create(String)
		 */
		SelectOrdered orderBy(OrderByField... orderByFields);

		/**
		 * Add one or more {@link OrderByField order by fields}.
		 *
		 * @param orderByFields the fields to order by.
		 * @return {@code this} builder.
		 * @see OrderByField#create(String)
		 */
		SelectOrdered orderBy(Collection<? extends OrderByField> orderByFields);
	}

	/**
	 * Interface exposing {@code WHERE} methods.
	 */
	interface SelectWhere extends SelectOrdered, BuildSelect {

		/**
		 * Apply a {@code WHERE} clause.
		 *
		 * @param condition the {@code WHERE} condition.
		 * @return {@code this} builder.
		 * @see Where
		 * @see Condition
		 */
		SelectWhereAndOr where(Condition condition);
	}

	/**
	 * Interface exposing {@code AND}/{@code OR} combinatior methods for {@code WHERE} {@link Condition}s.
	 */
	interface SelectWhereAndOr extends SelectOrdered, BuildSelect {

		/**
		 * Combine the previous {@code WHERE} {@link Condition} using {@code AND}.
		 *
		 * @param condition the condition, must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see Condition#and(Condition)
		 */
		SelectWhereAndOr and(Condition condition);

		/**
		 * Combine the previous {@code WHERE} {@link Condition} using {@code OR}.
		 *
		 * @param condition the condition, must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see Condition#or(Condition)
		 */
		SelectWhereAndOr or(Condition condition);
	}

	/**
	 * Interface exposing {@code JOIN} methods.
	 */
	interface SelectJoin extends BuildSelect {

		/**
		 * Declare a {@code JOIN} {@code table}.
		 *
		 * @param table name of the table, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see Join
		 * @see SQL#table(String)
		 */
		SelectOn join(String table);

		/**
		 * Declare a {@code JOIN} {@link Table}.
		 *
		 * @param table name of the table, must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see Join
		 * @see SQL#table(String)
		 */
		SelectOn join(Table table);
	}

	/**
	 * Interface exposing {@code ON} methods to declare {@code JOIN} relationships.
	 */
	interface SelectOn {

		/**
		 * Declare the source column in the {@code JOIN}.
		 *
		 * @param column name of the source column, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectOnConditionComparison on(String column);

		/**
		 * Declare the source column in the {@code JOIN}.
		 *
		 * @param column the source column, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectOnConditionComparison on(Expression column);
	}

	/**
	 * Interface declaring the target column comparison relationship.
	 */
	interface SelectOnConditionComparison {

		/**
		 * Declare an equals {@link Condition} between the source column and the target {@code column}.
		 *
		 * @param column name of the target column, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectFromAndJoinCondition equals(String column);

		/**
		 * Declare an equals {@link Condition} between the source column and the target {@link Column}.
		 *
		 * @param column the target column, must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectFromAndJoinCondition equals(Expression column);
	}

	/**
	 * Builder exposing JOIN and {@code JOIN … ON} continuation methods.
	 */
	interface SelectOnCondition extends SelectJoin, BuildSelect {

		/**
		 * Declare an additional source column in the {@code JOIN}.
		 *
		 * @param column the column name, must not be {@literal null} or empty.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectOnConditionComparison and(String column);

		/**
		 * Declare an additional source column in the {@code JOIN}.
		 *
		 * @param column the column, must not be {@literal null}.
		 * @return {@code this} builder.
		 * @see SQL#column(String)
		 * @see Table#column(String)
		 */
		SelectOnConditionComparison and(Expression column);
	}

	/**
	 * Interface exposing the {@link Select} build method.
	 */
	interface BuildSelect {

		/**
		 * Build the {@link Select} statement and verify basic relationship constraints such as all referenced columns have a {@code FROM} or {@code JOIN} table import.
		 *
		 * @return the build and immutable {@link Select} statement.
		 */
		Select build();
	}
}
