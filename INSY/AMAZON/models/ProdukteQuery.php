<?php

namespace app\models;

/**
 * This is the ActiveQuery class for [[Produkte]].
 *
 * @see Produkte
 */
class ProdukteQuery extends \yii\db\ActiveQuery
{
    /*public function active()
    {
        return $this->andWhere('[[status]]=1');
    }*/

    /**
     * {@inheritdoc}
     * @return Produkte[]|array
     */
    public function all($db = null)
    {
        return parent::all($db);
    }

    /**
     * {@inheritdoc}
     * @return Produkte|array|null
     */
    public function one($db = null)
    {
        return parent::one($db);
    }
}
