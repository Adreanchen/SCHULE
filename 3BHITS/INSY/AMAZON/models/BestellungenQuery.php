<?php

namespace app\models;

/**
 * This is the ActiveQuery class for [[Bestellungen]].
 *
 * @see Bestellungen
 */
class BestellungenQuery extends \yii\db\ActiveQuery
{
    /*public function active()
    {
        return $this->andWhere('[[status]]=1');
    }*/

    /**
     * {@inheritdoc}
     * @return Bestellungen[]|array
     */
    public function all($db = null)
    {
        return parent::all($db);
    }

    /**
     * {@inheritdoc}
     * @return Bestellungen|array|null
     */
    public function one($db = null)
    {
        return parent::one($db);
    }
}
