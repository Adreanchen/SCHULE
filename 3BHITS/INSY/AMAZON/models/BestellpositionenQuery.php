<?php

namespace app\models;

/**
 * This is the ActiveQuery class for [[Bestellpositionen]].
 *
 * @see Bestellpositionen
 */
class BestellpositionenQuery extends \yii\db\ActiveQuery
{
    /*public function active()
    {
        return $this->andWhere('[[status]]=1');
    }*/

    /**
     * {@inheritdoc}
     * @return Bestellpositionen[]|array
     */
    public function all($db = null)
    {
        return parent::all($db);
    }

    /**
     * {@inheritdoc}
     * @return Bestellpositionen|array|null
     */
    public function one($db = null)
    {
        return parent::one($db);
    }
}
