<?php

namespace app\models;

/**
 * This is the ActiveQuery class for [[Lieferanten]].
 *
 * @see Lieferanten
 */
class LieferantenQuery extends \yii\db\ActiveQuery
{
    /*public function active()
    {
        return $this->andWhere('[[status]]=1');
    }*/

    /**
     * {@inheritdoc}
     * @return Lieferanten[]|array
     */
    public function all($db = null)
    {
        return parent::all($db);
    }

    /**
     * {@inheritdoc}
     * @return Lieferanten|array|null
     */
    public function one($db = null)
    {
        return parent::one($db);
    }
}
