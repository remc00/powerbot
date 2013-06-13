package org.powerbot.script.lang;

import org.powerbot.script.methods.ClientFactory;
import org.powerbot.script.wrappers.Locatable;
import org.powerbot.script.wrappers.Nameable;

public abstract class GameNameQuery<K extends Locatable & Nameable> extends AbstractQuery<GameNameQuery<K>, K> implements Locatable.Query<GameNameQuery<K>> {
	public GameNameQuery(final ClientFactory factory) {
		super(factory);
	}

	@Override
	protected GameNameQuery<K> getThis() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameNameQuery<K> at(Locatable l) {
		return select(new Locatable.Matcher(l));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameNameQuery<K> within(double distance) {
		return within(ctx.players.getLocal(), distance);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameNameQuery<K> within(Locatable target, double distance) {
		return select(new Locatable.WithinRange(target, distance));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameNameQuery<K> nearest() {
		return nearest(ctx.players.getLocal());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameNameQuery<K> nearest(Locatable target) {
		return sort(new Locatable.NearestTo(target));
	}
}
