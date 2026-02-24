<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Lieferanten".
 *
 * @property int $LieferantenID
 * @property string $Lieferantenname
 * @property string|null $Lieferanten_Email
 *
 * @property Produkte[] $produktes
 */
class Lieferanten extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Lieferanten';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Lieferanten_Email'], 'default', 'value' => null],
            [['Lieferantenname'], 'required'],
            [['Lieferantenname', 'Lieferanten_Email'], 'string', 'max' => 255],
            [['Lieferanten_Email'], 'unique'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'LieferantenID' => Yii::t('app', 'Lieferanten ID'),
            'Lieferantenname' => Yii::t('app', 'Lieferantenname'),
            'Lieferanten_Email' => Yii::t('app', 'Lieferanten Email'),
        ];
    }

    /**
     * Gets query for [[Produktes]].
     *
     * @return \yii\db\ActiveQuery|ProdukteQuery
     */
    public function getProduktes()
    {
        return $this->hasMany(Produkte::class, ['LieferantenID' => 'LieferantenID']);
    }

    /**
     * {@inheritdoc}
     * @return LieferantenQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new LieferantenQuery(get_called_class());
    }

}
